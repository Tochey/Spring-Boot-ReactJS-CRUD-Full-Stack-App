import React from "react";
 import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
  import { faHouseChimney } from '@fortawesome/free-solid-svg-icons'
  import { Link } from "react-router-dom";
import "./header.css";
const header = () => {
  return (
    <div className="header-container">
      <h2>Employee Management System</h2>
      <Link to="/">
        <FontAwesomeIcon icon={faHouseChimney} className="onlyIcon" />
      </Link>
    </div>
  );
};

export default header;
