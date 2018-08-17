import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container, ButtonGroup } from 'reactstrap';

class Home extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
		  <ButtonGroup>
            <Button size="big" color="link" ><Link to="/query">Query</Link></Button>
            <Button size="big" color="link" ><Link to="/reports">Reports</Link></Button>
          </ButtonGroup>
        </Container>
      </div>
    );
  }
}

export default Home;