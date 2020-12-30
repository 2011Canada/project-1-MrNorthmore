import axios from 'axios';

export const ersBaseClient = axios.create({
    baseURL: "http://ec2-3-226-237-188.compute-1.amazonaws.com:8090/e720",
    headers: {
        'Content-Type': "application/json"
    }
})