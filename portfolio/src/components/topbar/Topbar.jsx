import React from 'react'
import './Topbar.scss'

export default function Topbar() {
  return (
    <div className='topbar'>
      <div className="wrapper">
        <div className="left">
          <a href="#intro" className='logo'>Anish Rachcha</a>
          <div className="itemContainer">
            <span>+91 9423749050</span>
            <span><a href="mailto:anishrachcha@gmail.com"></a></span>
            
          </div>
        </div>
      
        <div className="right">
        
        </div>
        
      </div>
      
    </div>
  )
}
