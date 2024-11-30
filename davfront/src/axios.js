
import axios from 'axios';
console.log(process.env.VUE_APP_API_URL);

const axiosInstance = axios.create({
    baseURL: process.env.VUE_APP_API_URL,
    timeout: 5000,
    headers: {
        'Content-Type': 'application/json',
    }
})

export const getAllClases = () => axiosInstance.get('');
export const getClaseByName = (name) => axiosInstance.get(`/${name}`);