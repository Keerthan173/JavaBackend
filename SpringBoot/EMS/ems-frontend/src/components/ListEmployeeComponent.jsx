import {useEffect, useState} from 'react'
import { deleteEmployee, listEmployees } from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom';

const ListEmployeeComponent = () => {

  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    fetchEmployees();
  }, []);
  // Reusable function to fetch all employees
  const fetchEmployees = () => {
    listEmployees()
      .then(response => {
        setEmployees(response.data);
      })
      .catch(error => {
        console.error("Error fetching employees:", error);
      });
  };
  /*
  | useEffect(() => { ... }, []) | Runs only once when component **mounts**                            |
  | listEmployees()              | Calls the API (GET request to your Spring Boot backend)             |
  | .then(response => { ... })   | Runs when data is successfully received                             |
  | setEmployees(response.data)  | Stores employee list in state so it can be shown in the UI          |
  | .catch(error => { ... })     | Catches and logs errors if the API call fails                       |
  */

  const navigator = useNavigate();

  function addNewEmployee(){
    navigator('/add-employee');
  }

  function updateEmployee(id){
    navigator(`/edit-employee/${id}`);
  }

  // Delete employee and refresh list
  const removeEmployee = (id) => {
    deleteEmployee(id)
      .then(() => {
        fetchEmployees(); // Refresh after delete
      })
      .catch(error => {
        console.error("Error deleting employee:", error);
      });
  };

  return (
    <div className='container'>
      <h2 className='text-center'>List of Employees</h2>

      <button className='btn btn-primary' onClick={addNewEmployee}>Add Employee</button>
      <br/>
      <br/>

      <table className='table table-striped table-bordered'>
        <thead>
          <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {
            employees.map(employee => 
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
                <td>
                  <button className='btn btn-info' onClick={() => updateEmployee(employee.id)}>Update</button>
                  <button className='btn btn-danger' onClick={() => removeEmployee(employee.id)} style={{marginLeft: '10px'}}>Delete</button>
                </td>
              </tr>
            )
          }
        </tbody>
      </table>
    </div>
  )
}

export default ListEmployeeComponent;