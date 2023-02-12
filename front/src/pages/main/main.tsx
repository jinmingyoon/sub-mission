/* eslint-disable no-return-await */
/* eslint-disable react-hooks/rules-of-hooks */
import { useState, useRef, useCallback, useEffect } from 'react';
import '../helper/css/menu.scss';
import axios from 'axios';
import { useQuery } from '@tanstack/react-query';
import selectMenuMain from '../helper/img/dimsum.png';
import HaderCategoryList from '../header/headercategoryList';
import HeaderPersontypeList from '../header/headerpersontypeList';

function Main() {
  const [form, setForm] = useState({
    categoryId: 0,
    persontype: 0,
  });

  const inputRef = useRef<any>(null);
  const imgRef = useRef<any>(null);
  const submitRef = useRef<any>(null);

  const { refetch: getFoodChoice } = useQuery<any, Error>(
    ['getFoodChoice'],
    async () => {
      return await axios.get(`/api/v1/food/type`, {
        params: { categoryId: form.categoryId, persontype: form.persontype },
      });
    },
    {
      enabled: false,
      retry: 2,
      onSuccess: (res) => {
        submitRefOption(true, '신중하게 메뉴 추천중입니다.', '#666666');
        inputRef.current.textContent = '';
        const foodname = res.data.payload.foodName;
        imgRef.current.style.display = 'inline-block';
        imgRef.current.setAttribute('class', 'animation');

        setTimeout(() => {
          imgRef.current.setAttribute('class', 'animation3');
          imgRef.current.style.display = 'none';
          inputRef.current.style.display = 'block';
          inputRef.current.textContent = foodname;

          submitRefOption(false, '추천해볼까요', '#528AF4');
        }, 1400);
      },
      onError: (err) => {
        console.log(err);
      },
    },
  );

  const handleSubmit = (e: any) => {
    e.preventDefault();

    if (form.categoryId !== 0 && form.persontype !== 0) {
      getFoodChoice();
    } else {
      submitRefOption(true, '모든 선택지를 선택하세요', '#B9062F');
      setTimeout(() => {
        submitRefOption(false, '추천해볼까요', '#528AF4');
      }, 700);
    }
  };

  const submitRefOption = (Yn: boolean, value: string, color: string) => {
    if (Yn === true) {
      submitRef.current.value = value;
      submitRef.current.style.backgroundColor = color;
      submitRef.current.setAttribute('disabled', Yn);
    }
    if (Yn === false) {
      submitRef.current.value = '추천해볼까요';
      submitRef.current.style.backgroundColor = '#528AF4';
      submitRef.current.removeAttribute('disabled');
    }
  };

  const getDataValue = useCallback(
    (value: number, name: string) => {
      setForm({
        ...form,
        [name]: value,
      });
    },
    [form],
  );

  return (
    <div className="container">
      <form className="container-center" onSubmit={handleSubmit}>
        <table>
          <thead>
            <tr>
              <th> 오늘은 어떤 메뉴 추천할까?</th>
            </tr>
          </thead>
          <tbody>
            <div className="section_search">
              <HaderCategoryList getDataValue={getDataValue} />
              <HeaderPersontypeList getDataValue={getDataValue} />
              <div className="result">
                <img
                  ref={imgRef}
                  src={selectMenuMain}
                  alt="메뉴고민중"
                  className="animation3"
                />
                <p ref={inputRef}>고민중입니다.</p>
              </div>
              <div className="submit">
                <input
                  type="submit"
                  value="추천해볼까요"
                  ref={submitRef}
                  id="input_submit"
                />
              </div>
            </div>
          </tbody>
        </table>
      </form>
    </div>
  );
}

export default Main;
