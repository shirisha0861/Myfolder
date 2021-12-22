import React from 'react'
class App extends React.Component
{
    constructor()
    {
      super()
      this.intervalObj = undefined
      this.state = {
          title : "Good Morning",
          num : 25,
          cities : [
            "Delhi" , "Bhopal" , "Pune" , "Raipur" , "Indore"
          ]
      }
    }
    startIncrement = ()=>{
      this.intervalObj = setInterval(()=>
          {
            this.setState({num : this.state.num+5})
          },100);
    }
    stopIncrement = ()=>{
          clearInterval(this.intervalObj)
          this.setState({num : 0})
    }
    change = ()=>{
        console.log(this.state)
        //this.state.title = "Good Evening"
        this.setState({title:"Good Evening"})
        console.log(this.state)
    }
    addCity = ()=>{
      var city = document.getElementById('t1').value;
      this.setState({cities : [...this.state.cities,city] })
    }    
    render()
    {    
      console.log("Render Run ...... ")
      return <div>
          <h1>My first ReactJS Component</h1>
          <b>{this.state.title} : {this.state.num}</b>
          <br/>      
          <button onClick={this.change}>Change Title</button>  
          &nbsp;
          <button onClick={this.startIncrement}>Start</button>
          &nbsp;
          <button onClick={this.stopIncrement}>Stop</button>
          <hr/>
         
          <input type="text" id="t1" placeholder='New City'/>&nbsp;
          <button onClick={this.addCity}>Add New City</button>
          <ul>
            {this.state.cities.map((ct)=>
            {
              return <li>{ct}</li>
            })}
          </ul>
      </div>
    }
}
export default App;
