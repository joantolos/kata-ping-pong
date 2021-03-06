$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("game.feature");
formatter.feature({
  "line": 1,
  "name": "Game",
  "description": "",
  "id": "game",
  "keyword": "Feature"
});
formatter.before({
  "duration": 277391769,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Checking if the service does ping",
  "description": "",
  "id": "game;checking-if-the-service-does-ping",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Ping"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I perform a \"GET\" to \"http://localhost:7111/ping\" end point",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "the response at the json path \"move\" includes \"Ping!\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "GET",
      "offset": 13
    },
    {
      "val": "http://localhost:7111/ping",
      "offset": 22
    }
  ],
  "location": "PingPongAcceptance.java:25"
});
formatter.result({
  "duration": 871617640,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "move",
      "offset": 31
    },
    {
      "val": "Ping!",
      "offset": 47
    }
  ],
  "location": "PingPongAcceptance.java:29"
});
formatter.result({
  "duration": 558045270,
  "status": "passed"
});
formatter.before({
  "duration": 398217,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Checking if the service does pong",
  "description": "",
  "id": "game;checking-if-the-service-does-pong",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@Pong"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "I perform a \"GET\" to \"http://localhost:7111/pong\" end point",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "the response at the json path \"move\" includes \"Pong!\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "GET",
      "offset": 13
    },
    {
      "val": "http://localhost:7111/pong",
      "offset": 22
    }
  ],
  "location": "PingPongAcceptance.java:25"
});
formatter.result({
  "duration": 21387567,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "move",
      "offset": 31
    },
    {
      "val": "Pong!",
      "offset": 47
    }
  ],
  "location": "PingPongAcceptance.java:29"
});
formatter.result({
  "duration": 9415882,
  "status": "passed"
});
formatter.before({
  "duration": 287026,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Checking if the service does ping or pong when playing",
  "description": "",
  "id": "game;checking-if-the-service-does-ping-or-pong-when-playing",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@Play"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "I perform a \"GET\" to \"http://localhost:7111/play\" end point",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "the response at the json path \"move\" includes \"Ping!\" or \"Pong!\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "GET",
      "offset": 13
    },
    {
      "val": "http://localhost:7111/play",
      "offset": 22
    }
  ],
  "location": "PingPongAcceptance.java:25"
});
formatter.result({
  "duration": 12941555,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "move",
      "offset": 31
    },
    {
      "val": "Ping!",
      "offset": 47
    },
    {
      "val": "Pong!",
      "offset": 58
    }
  ],
  "location": "PingPongAcceptance.java:32"
});
formatter.result({
  "duration": 13641684,
  "status": "passed"
});
});