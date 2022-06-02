import logo from "./logo.svg";
import Header from "./Components/header/Header"
import AddEmployee from "./Components/addEmployee/AddEmployee"
import "./App.css";
import DisplayEmployee from "./Components/displayEmployees/DisplayEmployee";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import UpdateEmployee from "./Components/updateEmployee/UpdateEmployee";

function App() {
  return (
    <Router>
      <>
        <Header />
        <Routes>
          <Route exact path="/add" element={<AddEmployee />} />
          <Route exact path="/" element={<DisplayEmployee />} />
          <Route exact path="/update/:id" element={<UpdateEmployee />} />
        </Routes>
      </>
    </Router>
  );

}

export default App;
