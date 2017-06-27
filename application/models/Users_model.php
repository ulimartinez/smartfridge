<?php
class Users_Model extends CI_Model{
    public function __construct(){
        parent::__construct();
        $this->load->database();
    }
    public function get_user_info($id){
        $sql = "SELECT * FROM usuarios WHERE id = $id";
        $query = $this->db->query($sql);
        return $query->result();
    }
}