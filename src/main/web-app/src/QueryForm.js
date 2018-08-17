import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, ButtonGroup, Table, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import ReactTable from "react-table";
import Select from 'react-select';

import AppNavbar from './AppNavbar';

class QueryForm extends Component {

  emptyItem = {
    countryName: '',
    countryCode: ''
  };

  constructor(props) {
    super(props);
    this.state = {
      item: this.emptyItem,
	  airports:[],
	  showResult:false
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let item = {...this.state.item};
    item[name] = value;
    this.setState({item});
  }

  async handleSubmit(event) {
    event.preventDefault();
    const {airports, item, showResult} = this.state;
	
	if (item.countryCode) {
		fetch('/api/airport/query/byCode/'+this.state.item.countryCode, {
		  method: 'GET',
		  headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		  }
		})
		.then(response => response.json())
        .then(data => {
		  this.setState({airports: data, showResult: true})
		  });
	} else if (item.countryName) {
		fetch('/api/airport/query/byName/'+this.state.item.countryName, {
		  method: 'GET',
		  headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		  }
		})
		.then(response => response.json())
        .then(data => {
		  this.setState({airports: data, showResult: true})
		  });
	}
    
    
  }

  async handleButtonClick(event, row){
	  var id = row._original.id;
	  this.props.history.push('/runways/'+ id);
	  
  }
  render() {
    const {airports,item} = this.state;

	const columns = [{
		Header: 'Airport Name',
		accessor: 'name'
	  }, {
		Header: 'Airport Identifications',
		accessor: 'ident'
	  }, {
		Header: 'Airport Type',
		accessor: 'type'
	  },{
		  Header: '',
		  id: 'click-me-button',
		  accessor: 'id',
		  Cell: ({ row }) => (<button onClick={(e) => this.handleButtonClick(e, row)}>Runways</button>)
	  }]
	  
	
    return <div>
      <AppNavbar/>
      <Container>
        <Form onSubmit={this.handleSubmit}>
          <div className="row">
            <FormGroup className="col-md-4 mb-3">
              <Label for="countryCode">Country Code</Label>
              <Input type="text" name="countryCode" id="countryCode" value={item.countryCode || ''}
                     onChange={this.handleChange} autoComplete="address-level1"/>
            </FormGroup>
            <FormGroup className="col-md-5 mb-3">
              <Label for="countryName">Country Name</Label>
              <Input type="text" name="countryName" id="countryName" value={item.countryName || ''}
                     onChange={this.handleChange} autoComplete="address-level1"/>
            </FormGroup>
          </div>
          <FormGroup>
            <Button color="primary" type="search">Search</Button>{' '}
          </FormGroup>
        </Form>
      </Container>
	  { this.state.showResult && 
		<Container fluid>
          <h3>Airports</h3>
          <ReactTable 
			data={this.state.airports}
			columns={columns}
			loading={this.state.isLoading}
			defaultPageSize={10}
			minRows={3}
		  />
		</Container>
	  }
	  
    </div>
  }
}

export default QueryForm;