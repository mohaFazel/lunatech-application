import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table, Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem, NavLink } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class ReportList extends Component {

  constructor(props) {
    super(props);
  }

  render() {
	  
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
		  <ButtonGroup>
            <Button size="big" color="link" ><Link to="/high">Highest Number of Airports</Link></Button>
            <Button size="big" color="link" ><Link to="/low">Lowest Number of Airports</Link></Button>
			<Button size="big" color="link" ><Link to="/runway">Type Of Runways Per Country</Link></Button>
			<Button size="big" color="link" ><Link to="/common">Most Common Runway Identification</Link></Button>
          </ButtonGroup>
        </Container>
      </div>
    );
  }
}

export default ReportList;