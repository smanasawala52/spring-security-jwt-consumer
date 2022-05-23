//SPDX-License-Identifier: MIT
pragma solidity ^0.6.6;
pragma experimental ABIEncoderV2;
struct Person {
    uint256  favoriteNumber  ;
    string  name  ;
}
contract SimpleStorage {
    // this will init to 0
    uint256  private favoriteUInt  ;
    address private owner ;
    constructor() public{
        owner = msg.sender;
    }
    
Person private person =  Person({favoriteNumber:1,name:"Shabbir"});
Person[] private people;
mapping(uint256 => Person) private peopleMap;

    function store(uint256 _favoriteUInt) public{
        favoriteUInt = _favoriteUInt;
    }
    function retrive() public view returns(uint256){
        return favoriteUInt;
    }
    function multiply (uint256 _favoriteUInt1,uint256 _favoriteUInt2) public pure returns(uint256){ 
        return _favoriteUInt1*_favoriteUInt2;
    }
    function addPerson(uint256 _favNum, string memory _name )  public {
        Person memory p  =  Person({favoriteNumber:_favNum,name:_name});
        people.push(p);
        peopleMap[_favNum] = p;
    }
     function retrivePerson(uint256 _favNum) public view returns(Person memory){
        return peopleMap[_favNum];
    }
    function retriveAllPeople() public view returns(Person[] memory){
        return people;
    }
}