import React from 'react';
import { NavLink } from 'react-router-dom';

function Header() {
  return (
    <>
      <div className='container-fluid'>
        <nav className="navbar navbar-expand-lg bg-dark navbar-dark">
          <div className="container-fluid">
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
              <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                <li className="nav-item">
                  <NavLink to="/" className="nav-link">Todo List</NavLink>
                </li>
              </ul>
              <h5 className="text-white mb-0">Log out</h5>
            </div>
          </div>
        </nav>
      </div>
    </>
  );
}

export default Header;
