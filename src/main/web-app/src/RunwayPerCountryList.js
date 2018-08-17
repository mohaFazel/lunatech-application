import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import ReactTable from "react-table";
import { Link } from 'react-router-dom';

class RunwayPerCountryList extends Component {

  constructor(props) {
    super(props);
    this.state = {runways: [], isLoading: true};
  }

  componentDidMount() {
    this.setState({isLoading: true});
    fetch('api/runway/report/runwayTypesByCountry')
      .then(response => response.json())
      .then(data => {
		  
		  this.setState({runways: data, isLoading: false})
		  });
  }

  render() {
    const {runways, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const columns = [{
		Header: 'Country Name',
		accessor: 'countryName'
	  }, {
		Header: 'Runway Identifications',
		accessor: 'runwayTypes'
	  }]

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
        <Container fluid>
          <h3>Common Runway Identification</h3>
          <ReactTable 
			data={this.state.runways}
			columns={columns}
			loading={this.state.isLoading}
			defaultPageSize={10}
			minRows={3}
		  />
        </Container>
      </div>
    );
  }
}

export default RunwayPerCountryList;