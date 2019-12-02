import Axios from 'axios'
import QS from 'qs'
import {Toast} from 'vant'
// import store from '@/store/index'
import router from 'vue-router'

//环境切换
if (process.env.NODE_ENV == 'development') {
  Axios.defaults.baseURL = 'http://localhost:9000'
} else if (process.env.NODE_ENV == 'debug') {
  Axios.defaults.baseURL = 'http://localhost:9200'
} else if (process.env.NODE_ENV == 'debug') {
  Axios.defaults.baseURL = 'http://localhost:9400'
}
//默认超时时间
Axios.defaults.timeout = 10 * 1000;
//post请求头
Axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
//请求拦截器
// Axios.interceptors.request.use(
//   config => {
//     //每次请求判断vuex是否存在token
//     //如果存在则同意在header都加上token
//     //即使本地存在token,也有可能token是过期的,所以在响应拦截器中要对返回状态进行判断
//     const token = store.state.token;
//     token && (config.headers.Authorization = token);
//     return config;
//   },
//   error => {
//     return Promise.error(error)
//   }
// )
Axios.interceptors.response.use(
  response => {
    //如果状态码为200,请求成功
    //否则抛出错误
    if (response.status === 200) {
      return Promise.resolve(response);
    } else {
      return Promise.reject(response);
    }
  },
  //服务器不是2开头的情况
  error => {
    if (error.response.status) {
      switch (error.response.status) {
        case 401:
          router.replace({
            path: '/login',
            query: {
              redirect: router.currentRoute.fullPath
            }
          });
          break;
        default:
          Toast({
            message: error.response.data.message,
            duration: 1500,
            forbidClick: true
          });
      }
      return Promise.reject(error.response);
    }
  }
)

/**
 * get方法，对应get请求
 * @param {String} url [请求的url地址]
 * @param {Object} params [请求时携带的参数]
 */
export function get(url, params) {
  return new Promise(((resolve, reject) => {
    Axios.get(url, {
      params: params
    }).then(res => {
      resolve(res.data);
    }).catch(err => {
      reject(err.data)
    })
  }));
}

export function post(url, params) {
  return new Promise(((resolve, reject) => {
    Axios.post(url, QS.stringify(params))
      .then(res => {
        reslove(res.data);
      }).catch(err => {
        reject(err.data)
    })
  }));
}
