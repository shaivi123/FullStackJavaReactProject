import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useParams } from "react-router-dom";



export default function Home(){

    const [student, setStudent]= useState([])

    const {id} = useParams();

    useEffect(() => {
       loadStudent();
    }, []);

    const loadStudent = async () => {
        const result =await axios.get("http://localhost:9090/getAll");
        setStudent(result.data);
    };

    const deleteStudent = async (id) => {
        await axios.delete(`http://localhost:9090/student/${id}`)
        loadStudent();
    }


   return(
    <div className="container">
        <div className="py-4">
        <table className="table border shadow">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Address</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    {
        student.map((student, index) => (
    <tr>
      <th scope="row" key={index}>{index + 1 }</th>
      <td>{student.name}</td>
      <td>{student.address}</td>
      <td>
        <Link className="btn btn-primary mx-2" 
        to={`/viewstudent/${id}`}>
            View</Link>
        <Link className="btn btn-outline-primary mx-2"
        to={`/editstudent/${student.id}`}>
        Edit</Link>
        <button className="btn btn-danger mx-2"
        onClick={() => deleteStudent(student.id)}>
            Delete</button>
      </td>
    </tr>
        ))
    }
    
  </tbody>
</table>
        </div>
    </div>
   )
}