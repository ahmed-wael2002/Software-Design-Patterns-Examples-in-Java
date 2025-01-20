<?php

class DbConnection {
    private $host = "localhost";
    private $username = "root";
    private $password = "";
    private $database_name = "test";
    private $conn;
    private static $instance;   // notice the instance is a static variable 

    // notice the constructor is private 
    private function _construct(){
        $this->conn = new mysqli($this->host, $this->username, $this->password, $this->database_name);
    }

    // notice the getInstance function is static
    public static function getInstance(){
        if (self::$instance == null){
            $instance = new DbConnection();
        }
        else{
            echo "Instance already exists";
        }
        return self::$instance;
    }

    // Some functions to interact with the database 
}

?>