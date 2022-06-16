import React, {useState} from "react";
import './App.css';
import axios from "axios";
import {Dropzone} from "./components/Dropzone";

const App = () => {
    const [files, setFiles] = useState([])

    const handleUpload = (e) =>{
        let formData = new FormData();
        for (let i = 0; i < files.length; i++) {
            formData.append("files", files[i])
        }

        axios.post("http://localhost:8080/api/v1/upload", formData,
            {
                headers: {
                    "Content-Type": "multipart/form-data"
                }, responseType: 'arraybuffer'
            }).then((response) => {
            const url = window.URL.createObjectURL(new Blob([response.data]));
            const link = document.createElement('a');
            link.href = url;
            link.setAttribute('download', 'file.pdf'); //or any other extension
            document.body.appendChild(link);
            link.click();
        }).catch(err => {
            console.log(err.status)
        })
    }
    return (
        <div className="body">
            <div className="title_wrapper">
                <h1 className="title">Let's PDF!</h1>
                <h4 className="subTitle">
                    Easy <span className="spanRed">.img</span> to <span className="spanGreen">.pdf</span> converter
                </h4>
            </div>
            <div>
                <Dropzone setFiles={setFiles} files={files}/>
            </div>
            <button disabled={!files.length} onClick={(e) => handleUpload(e)}>
                Convert!</button>
        </div>
    );
}

export default App;