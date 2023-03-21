import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import axios from "axios";

export default function ViewStudent(){

    const [student, setStudent] = useState({
        name:"",
        address:""
    })

    const {id} = useParams();

    useEffect(() => {
        loadStudent();
      }, [])

    const loadStudent = async () => {
        const response = await axios.get(`http://localhost:9090/student/${id}`);
        setStudent(response.data);
    };

    return(
        <div className="containe">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Student Details</h2>

                    <div className="card">
                        <div className="card-header">
                            Details of student id :
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">
                                    <b>Name:</b>
                                    {student.name}
                                </li>
                                <li className="list-group-item">
                                    <b>Address:</b>
                                    {student.address}
                                </li>
                            </ul>
                        </div>
                    </div>
                    <Link className="btn btn-primary my-2" to={"/"}>
                        Back to Home
                    </Link>
                </div>
            </div>
        </div>
    )
}