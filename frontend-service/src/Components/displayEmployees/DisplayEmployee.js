import React, { useEffect, useState } from "react";
import "./displayEmployee.css";
import { Link, useNavigate, useParams } from "react-router-dom";
import axios from "axios";

const API_URL = "http://localhost:8080/v1/get/all";

function Display() {
  let [employee, setEmployee] = useState([]);

  useEffect(() => {
    axios.get(API_URL).then((response) => setEmployee(response.data.data));
  });

  let nav = useNavigate();
  function editEmployee(e, id) {
    e.preventDefault();

    nav(`/update/${id}`);

  }

  return (
    <>
      <>
        <table>
          <tbody>
            <tr>
              <th>FullName</th>
              <th>Email</th>
              <th>Department</th>
              <th>Age</th>
              <th>Actions</th>
            </tr>
            {employee.map((e) => (
              <tr>
                <td>{e.name} </td>
                <td>{e.email}</td>
                <td>{e.department}</td>
                <td>{e.age}</td>
                <td>
                  <button
                    type="button"
                    className="updateBtn"
                    onClick={(event) => editEmployee(event, e.id)}
                  >
                    UPDATE
                  </button>
                  <button
                    type="button"
                    className="deleteBtn"
                    onClick={() =>
                      axios.delete(`http://localhost:8080/v1/delete/${e.id}`)
                    }
                  >
                    DELETE
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        <div className="add-new">
          <Link to="/add">
            <button type="button" className="add-newBtn">
              ADD NEW EMPLOYEE
            </button>
          </Link>
        </div>
      </>
    </>
  );
}

const DisplayEmployee = () => {
  return (
    <>
      <Display />
    </>
  );
};

export default DisplayEmployee;
