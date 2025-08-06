import axios from "axios"; // axios - Connect React frontend to Spring Boot backend.

const REST_API_BASE_URL = 'http://localhost:8080/api/employees';

// Get all employees
export const listEmployees = () => {
  return axios.get(REST_API_BASE_URL);
}
/*
Makes a GET request to: http://localhost:8080/api/employees
=> Maps to @GetMapping("/api/employees") in Spring Boot
*/

// Create a new employee
export const createEmployee = (employee) => {
  return axios.post(REST_API_BASE_URL, employee);
}
/*
POST request with employee data
=> Maps to @PostMapping("/api/employees")
*/

// Get a single employee by ID
export const getEmployee = (employeeId) => {
  return axios.get(`${REST_API_BASE_URL}/${employeeId}`);
}
/*
GET request to /api/employees/{id}
=> Maps to @GetMapping("/api/employees/{id}")
*/

// Update an existing employee
export const updateEmployee = (employeeId, employee) => {
  // return axios.put(REST_API_BASE_URL + '/' + employeeId, employee);        // Using String Concatenation
  return axios.put(`${REST_API_BASE_URL}/${employeeId}`, employee);           // Using Template Literals
}
/*
PUT request to /api/employees/{id} with updated data
=> Maps to @PutMapping("/api/employees/{id}")
*/

export const deleteEmployee = (employeeId) => {
  axios.delete(REST_API_BASE_URL + "/" + employeeId); 
}
