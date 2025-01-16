<?php 

// Database Singleton class
class DbConnection{
    private $hostname;
    private $username = "root";
    private $password = "";
    private $con;
    private static $instance;

    function __construct(){
        $this->con = new mysqli($this->hostname, $this->username, $this->password);
        if($this->con->connect_error){
            die("Error occured while connecting to the database " . $this->con->connect_error);
        }
    }

    public static function getInstance(){
        if(self::$instance == null){
            self::$instance = new DbConnection();
        }
        return self::$instance;
    } 

    public function run_query($sql) : bool{
        return $this->con->query($sql);
    }
}
 
?>