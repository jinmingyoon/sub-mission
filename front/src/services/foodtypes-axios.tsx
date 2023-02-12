/* eslint-disable class-methods-use-this */
import axios from 'axios';
import { foodchoiceType } from '../pages/helper/type/foodType';

const FOOD_CHOICES_BASE_REST_API_URL = '/api/v1/food';

class FoodTypesAxios {
  getAllFoodTypeList() {
    return axios.get(`${FOOD_CHOICES_BASE_REST_API_URL}/types`);
  }

  getFoodTypeChoice(form: foodchoiceType) {
    return axios.get(`${FOOD_CHOICES_BASE_REST_API_URL}/type`, {
      params: form,
    });
  }
}

export default new FoodTypesAxios();
