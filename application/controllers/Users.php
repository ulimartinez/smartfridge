<?php
require(APPPATH . 'libraries/REST_Controller.php');
Class Users extends REST_Controller {
    public function __construct(){
        parent::__construct();
    }
    public function user_get(){
        $this->load->model('users_model');
        $id = $this->get('id');
        $user = $this->users_model->get_user_info($id);
        $this->response($user, 200);
    }
    public function user_post(){

    }

    public function que_paso($amiguito){
        //que paso amiguito?
    }
}
?>
