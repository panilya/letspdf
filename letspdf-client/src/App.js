import logo from './logo.svg';
import React from "react";
import './App.css';
import axios from "axios";

class App extends React.Component {
  state = {
    files: null,
  };

  handleFile(e) {
    let files = e.target.files;
    this.setState({ files });
  }

  handleUpload(e) {
      let files = this.state.files;

      let formData = new FormData();

      for (let i = 0; i < files.length; i++) {
          formData.append("files", files[i])
      }

      axios.post("http://localhost:8082/api/v1/upload", formData,
          {
              headers: {
                  "Content-Type": "multipart/form-data"
              }
          }).then(() => {
          console.log("success")
      }).catch(err => {
          console.log(err.status)
      })
  }
  render() {
    return (
        <div>
          <h1>Select your files</h1>
          <input
              type="file"
              multiple="multiple"
              onChange={(e) => this.handleFile(e)}
          />
          <button onClick={(e) => this.handleUpload(e)}
          >Send Files</button>
        </div>
    );
  }
}

export default App;
