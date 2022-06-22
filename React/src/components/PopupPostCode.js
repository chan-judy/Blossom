import React from 'react';
import DaumPostcode from "react-daum-postcode";
 
const PopupPostCode = (props) => {
	// 우편번호 검색 후 주소 클릭 시 실행될 함수, data callback 용
    const handlePostCode = (data) => {
        const fullAddress = data.address;
        const extraAddress = ''; 
        
        if (data.addressType === 'R') {
          if (data.bname !== '') {
            extraAddress += data.bname;
          }
          if (data.buildingName !== '') {
            extraAddress += (extraAddress !== '' ? `, ${data.buildingName}` : data.buildingName);
          }
          fullAddress += (extraAddress !== '' ? ` (${extraAddress})` : '');
        }
        console.log(data)
        console.log(fullAddress)
        console.log(data.zonecode)
        props.onClose()
    }
 
    const postCodeStyle = {
        position: "absolute",
        top: "131%",
        left : "38.5%",
        width: "600px",
        height: "700px",
        border: "3px solid #E0E0E0",
      };

      const postCode_btn ={
        position: "absolute",
        botton : "30px",
        left : "700px",
        color : "#fff",
        size : "200px"
      }

    return(
        <div>
            <DaumPostcode style={postCodeStyle} onComplete={handlePostCode} />
           <p onClick={() => {props.onClose(true)}} style={postCode_btn} 
            >X</p>
        </div>
    )
}
 
export default PopupPostCode;