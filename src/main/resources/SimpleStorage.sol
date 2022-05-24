//SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract SimpleStorage {
    uint256 private favoriteNumber;
    string private message;
    address private owner;

    //constructor() {
    //    owner = msg.sender;
    //}
	constructor(string memory _msg) {
        owner = msg.sender;
        message = _msg;
    }

    struct People {
        uint256 favoriteNumber;
        string name;
    }
    People private person = People({favoriteNumber: 1, name: "Shabbir"});
    mapping(string => People) private people;

    function addPerson(string memory _name, uint256 _favNum) public {
        People memory p = People({favoriteNumber: _favNum, name: _name});
        people[_name] = p;
    }

    function retrivePeople(string memory _name)
        public
        view
        returns (People memory)
    {
        return people[_name];
    }

    function store(uint256 _favNum) public {
        favoriteNumber = _favNum;
    }

    function retrive() public view returns (uint256) {
        return favoriteNumber;
    }

    function getPerson() public view returns (People memory) {
        return person;
    }

    function getMessage() public view returns (string memory) {
        return message;
    }

    function getOwner() public view returns (address) {
        return owner;
    }
}
