import React, {useCallback} from 'react'
import { useDropzone } from "react-dropzone";

import "./DropZone.css";


export const MyDropzone = ({setFiles , files}) => {

  const onDrop = useCallback(acceptedFiles => {
    setFiles((prev) => [...prev,...acceptedFiles])
    console.log(acceptedFiles)
    console.log(typeof(files))
  }, [])

  const {acceptedFiles,getRootProps, getInputProps, isDragActive} = useDropzone({onDrop
  })

  const onDelete = (ID) => {
    const newList = files.filter((item,index) => index !== ID);

    setFiles(newList);
  }

  const fileList = files.map((file,id) => (
    <li key={id} className='li' >
      <div className='trash_button'>
         <i onClick={() => onDelete(id)} className="gg-trash"></i> 
      </div>
      <p className='file_info' >{file.path} - {(file.size / 1000).toFixed(2)} Kb</p>
    </li>
  ));

  return (
    <div>
    <div className='dropzone-div' {...getRootProps()}>
      <input {...getInputProps()} />
      {
        isDragActive ?
          <p className='dzone_message'>Drop the files here ...</p> :
          <p className='dzone_message'>Drag 'n' drop some files here, or click to select files</p>
      }
    </div >
    <div style={{opacity: files.length === 0 ? '0%':'100%', transitionDuration:'0.2s'}} className='files_list'>
      <div className='filesList_div'>
      {fileList}
      </div>
    </div>
    </div>
  )
}
