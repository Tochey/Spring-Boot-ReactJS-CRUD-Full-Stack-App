import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import axios from "axios";

const UpdateEmployee = () => {
  let { id } = useParams();

  const [employee, setEmployee] = useState({
    name: "",
    email: "",
    department: "",
    age: 0,
  });

  useEffect(() => {
    axios.get("http://localhost:8080/v1/get/" + id).then((response) => {
      setEmployee(response.data.data);
    });
  }, []);

  const handleChange = function (e) {
    e.preventDefault();

    let userInput = e.target.value;

    setEmployee({
      ...employee,
      [e.target.name]: userInput,
    });
  };

  const handle = function () {
    document.querySelectorAll("#to-clear").forEach((e) => (e.value = ""));
  };

  return (
    <>
      <div className="employee-div">
        <label htmlFor="fullName" className="full-name-label">
          Full Name
        </label>
        <br />
        <input
          id="to-clear"
          type="text"
          value={employee.name}
          name="name"
          onChange={(e) => handleChange(e)}
        ></input>
        <br />
        <label htmlFor="email"> Email </label>
        <br />
        <input
          id="to-clear"
          type="text"
          name="email"
          value={employee.email}
          onChange={(e) => handleChange(e)}
        ></input>
        <br />

        <label htmlFor="department"> Department </label>
        <br />
        <input
          id="to-clear"
          type="text"
          name="department"
          value={employee.department}
          onChange={(e) => handleChange(e)}
        ></input>
        <br />
        <label htmlFor="age"> Age </label>
        <br />
        <input
          id="to-clear"
          type="text"
          name="age"
          value={employee.age}
          onChange={(e) => handleChange(e)}
        ></input>
        <br />
        <div className="btn-div">
          <Link to="/">
            <button
              type="submit"
              className="submitBtn"
              onClick={() =>
                axios.put(
                  "http://localhost:8080/v1/update/" + employee.id,
                  employee
                )
              }
            >
              Update Employee
            </button>
          </Link>

          <button className="clearBtn" onClick={handle}>
            Clear
          </button>
        </div>
      </div>
    </>
  );
};

export default UpdateEmployee;
