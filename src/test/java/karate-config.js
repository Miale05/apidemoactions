function fn() {
  var env = karate.env; // get system property 'karate.env'
  
  if (!env) {
    env = "qa";
  }

  karate.log("karate.env system property was:", env);

  var config = {
    baseApiUrl: ""
  };

  if (env == "qa") {
    config.baseApiUrl = "http://localhost:8080/api/"
  } else if (env == "prod") {
    config.baseApiUrl = "http://localhost:8080/api"
  }

  karate.configure('connectTimeout', 50000);
  karate.configure('readTimeout', 50000);
  karate.configure('logPrettyRequest', true);
  karate.configure('logPrettyResponse', true);
  return config;
}
