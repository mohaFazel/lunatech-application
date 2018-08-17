import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import ReactTable from "react-table";
import { Link, withRouter } from 'react-router-dom';

class AirportRunawayList extends Component {

  constructor(props) {
    super(props);
    this.state = {runways: [], isLoading: true};
  }

  componentDidMount() {
    this.setState({isLoading: true});
	var id = this.props.match.params.id;
	console.log(id);
    fetch('api/runway/query/'+id)
      .then(response => response.json())
      .then(data => {
		  this.setState({runways: data, isLoading: false})});
  }

  render() {
    const {runways, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

	const columns = [{
		Header: 'Airport Identification',
		accessor: 'airport_ident' // String-based value accessors!
	  }, {
		Header: 'Airport Name',
		accessor: 'airport.name'
	  }]
	

    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <h3>Runway</h3>
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

export default withRouter(AirportRunawayList);