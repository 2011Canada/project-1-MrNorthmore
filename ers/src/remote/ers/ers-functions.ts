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

export const ersGetAllReimbursementsByUser = async (author: string) => {
    let authorObj = {
        author
    }

    try {
        let res = await ersBaseClient.post('/reimbursements', authorObj);
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

export const ersGetAllPendingReimbursementsByUser = async (author: string) => {
    let authorObj = {
        author
    }

    try {
        let res = await ersBaseClient.post('/pending-reimbursements', authorObj);
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

export const ersGetAllPendingReimbursements = async () => {

    try {
        let res = await ersBaseClient.get('/pending-reimbursements');
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

export const ersGetAllReimbursements = async () => {

    try {
        let res = await ersBaseClient.get('/reimbursements');
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

export const ersUpdateReimbursement = async (reimbursementId:number, reimbursementResolver:number, reimbursementStatus:number) => {
    let updatedReimbursement = {
        reimbursementId,
        reimbursementResolver,
        reimbursementStatus
    }
    try {
        let res = await ersBaseClient.put('/pending-reimbursements', updatedReimbursement);
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

export const ersCreateNewReimbursement = async (reimbursementAmt:string, reimbursementDesc:string, reimbursementReceipt:string, reimbursementAuthor:string, reimbursementType:string) => {
    let newReimbursement = {
        reimbursementAmt,
        reimbursementDesc,
        reimbursementReceipt,
        reimbursementAuthor,
        reimbursementType
    }
    try {
        let res = await ersBaseClient.post('/reimbursements/new', newReimbursement);
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