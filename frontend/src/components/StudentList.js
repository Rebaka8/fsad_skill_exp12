import React, { useEffect, useState } from "react";
import axios from "axios";

function StudentList({ refresh }) {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    fetchStudents();
  }, [refresh]);

  const fetchStudents = () => {
    axios.get("http://localhost:8080/students")
      .then(res => setStudents(res.data));
  };

  const deleteStudent = (id) => {
    axios.delete(`http://localhost:8080/students/${id}`)
      .then(() => fetchStudents());
  };

  return (
    <div>
      <h2>Student List</h2>
      <table border="1">
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {students.map(s => (
            <tr key={s.id}>
              <td>{s.name}</td>
              <td>{s.email}</td>
              <td>{s.course}</td>
              <td>
                <button onClick={() => deleteStudent(s.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default StudentList;