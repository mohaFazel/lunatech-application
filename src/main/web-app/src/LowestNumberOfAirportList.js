import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import ReactTable from "react-table";
import { Link } from 'react-router-dom';

class LowestNumberOfAirportList extends Component {

  constructor(props) {
    super(props);
    this.state = {countries: [], isLoading: true};
  }

  componentDidMount() {
    this.setState({isLoading: true});
    fetch('api/country/report/countryWithLowestNumberOfAirports')
      .then(response => response.json())
      .then(data => {
		  this.setState({countries: data, isLoading: false})
		  });
  }

  render() {
    const {countries, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const columns = [{
		Header: 'Country',
		accessor: 'country'
	  }, {
		Header: 'Count',
		accessor: 'count'
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
          <h3>Counries with Lowest number of Airports</h3>
          <ReactTable 
		  data={this.state.countries}
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

export default LowestNumberOfAirportList;