<?php
require(APPPATH . 'libraries/REST_Controller.php');
Class Ingredients extends REST_Controller {
    public function __construct(){
        parent::__construct();
    }
    public function user_get(){
        $this->load->model('ingredients_model');
        $id = $this->get('id');
        $id_got = $this->ingredients_model->get_user_ingredient($id);
        $this->response($id_got, 200);
    }
    public function info_get(){
        $this->load->model('ingredients_model');
        $id = $this->get('id');
        $info = $this->ingredients_model->get_ingredient_info($id);
        $this->response($info, 200);
    }
}
?>
