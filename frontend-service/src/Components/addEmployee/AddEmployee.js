import React, { useState } from "react";
import "./addEmployee.css";
import axios from "axios";
import { Link } from "react-router-dom";

const API_URL = "http://localhost:8080/v1/create";

const AddEmployee = () => {
  const [employee, setEmployee] = useState({
    name:"",
    email: "",
    department: "",
    age: 0,
  });

  const handleChange = (e) => {
    e.preventDefault();

    let userInput = e.target.value;

    setEmployee({
      ...employee,
      [e.target.name]: userInput,
    });


  }

  const handle = function (){
    document.querySelectorAll("#to-clear").forEach((e) => e.value = "" );
  }

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
          name="name"
          placeholder="Enter Full Name"
          onChange={(e) => handleChange(e)}
        ></input>
        <br />
        <label htmlFor="email"> Email </label>
        <br />
        <input
          id="to-clear"
          type="text"
          name="email"
          placeholder="Enter Email"
          onChange={(e) => handleChange(e)}
        ></input>
        <br />

        <label htmlFor="department"> Department </label>
        <br />
        <input
          id="to-clear"
          type="text"
          name="department"
          placeholder="Enter Department"
          onChange={(e) => handleChange(e)}
        ></input>
        <br />
        <label htmlFor="age"> Age </label>
        <br />
        <input
          id="to-clear"
          type="text"
          name="age"
          placeholder="Enter Age"
          onChange={(e) => handleChange(e)}
        ></input>
        <br />
        <div className="btn-div">
          <Link to="/">
            <button
              type="submit"
              className="submitBtn"
              onClick={() => axios.post(API_URL, employee)}
            >
              Add Employee
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

export default AddEmployee;
