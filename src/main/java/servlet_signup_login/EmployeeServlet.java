package servlet_signup_login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Employee;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    private List<Employee> employees;

    @Override
    public void init() throws ServletException {
        super.init();
        employees = new ArrayList<Employee>();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                default:
                    showEmployeeList(request, response);
            }
        } else {
            showEmployeeList(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "save":
                    saveEmployee(request, response);
                    break;
                case "search":
                    searchEmployees(request, response);
                    break;
                default:
                    showEmployeeList(request, response);
            }
        } else {
            showEmployeeList(request, response);
        }
    }

    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void saveEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");

        Employee newEmployee = new Employee();
        employees.add(newEmployee);

        response.sendRedirect("employee");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Employee employee = findEmployeeById(id);

        if (employee != null) {
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } else {
            response.sendRedirect("employee");
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Employee employee = findEmployeeById(id);

        if (employee != null) {
            employees.remove(employee);
        }

        response.sendRedirect("employee");
    }

    private void searchEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchType = request.getParameter("searchType");
        String searchValue = request.getParameter("searchValue");

        List<Employee> searchResults = new ArrayList<Employee>();

        if ("name".equals(searchType)) {
            for (Employee employee : employees) {
                if (employee.getName().equalsIgnoreCase(searchValue)) {
                    searchResults.add(employee);
                }
            }
        } else if ("id".equals(searchType)) {
            int id = Integer.parseInt(searchValue);
            Employee employee = findEmployeeById(id);
            if (employee != null) {
                searchResults.add(employee);
            }
        }

        request.setAttribute("employees", searchResults);
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
		return null;}}
