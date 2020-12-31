import axios from 'axios';

export const ersBaseClient = axios.create({
    baseURL: "http://localhost:8080/ErsServlets",
    headers: {
        'Content-Type': "application/json"
    }
})