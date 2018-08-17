import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CommonRunwayList from './CommonRunwayList';
import ReportList from './ReportList';
import RunwayPerCountryList from './RunwayPerCountryList';
import LowestNumberOfAirportList from './LowestNumberOfAirportList';
import HighestNumberOfAirportList from './HighestNumberOfAirportList';
import QueryForm from './QueryForm';
import AirportRunawayList from './AirportRunawayList'

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
		  <Route path='/reports' exact={true} component={ReportList}/>
          <Route path='/runway' exact={true} component={RunwayPerCountryList}/>
		  <Route path='/high' exact={true} component={HighestNumberOfAirportList}/>
		  <Route path='/low' exact={true} component={LowestNumberOfAirportList}/>
		  <Route path='/common' exact={true} component={CommonRunwayList}/>
		  <Route path='/query' exact={true} component={QueryForm}/>
		  <Route path='/runways/:id' exact={true} component={AirportRunawayList}/>
        </Switch>
      </Router>
    )
  }
}

export default App;