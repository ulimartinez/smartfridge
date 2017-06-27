<?php
class Ingredients_Model extends CI_Model{
    public function __construct(){
        parent::__construct();
        $this->load->database();
    }
    public function get_user_ingredient($id){
        $sql = "SELECT * FROM u_ingredientes WHERE u_id = $id";
        $query = $this->db->query($sql);
        return $query->result();
    }
    public function get_ingredient_info($id){
        $sql = "SELECT * FROM i_info WHERE id = $id";
        $query = $this->db->query($sql);
        return $query->result();
    }
}