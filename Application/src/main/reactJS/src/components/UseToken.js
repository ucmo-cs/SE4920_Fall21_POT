import React, { useState } from 'react';

function useToken() {

    const getToken=()=>{
       
        console.log("getTokenTEst");
        const tokenString = sessionStorage.getItem('token');
        const userToken = JSON.parse(tokenString);
        console.log(userToken);
        return userToken?.token
    }

    const [token, setToken] = useState(getToken()); 

    const saveToken = userToken=>{

        console.log("saveTokenTEst");
        sessionStorage.setItem('token', JSON.stringify(userToken));
        setToken(userToken.token);

    }

    return{
        setToken: saveToken, 
        token
    }

}

export default useToken;
