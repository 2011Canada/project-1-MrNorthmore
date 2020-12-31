import { ersBaseClient } from "."




export const ersLogin = async (username: string, password: string) => {
    let credentials = {
        username,
        password
    }

    try {
        let res = await ersBaseClient.post('/login', credentials);
        console.log(res.data);
        return res.data;
    }catch(e) {
        console.log(e);
        if(e.response){
            throw new Error(e.response.data);
        } else {
            throw new Error("Oops something went wrong")
        }
    }
}