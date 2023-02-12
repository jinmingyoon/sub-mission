/* eslint-disable react/destructuring-assignment */
import countryData from '../helper/dummy/country';

function HaderCategoryList(props: any) {
  const list = countryData;
  interface Contry {
    id: number;
    name: string;
  }

  const contrys: Contry[] = list as Contry[];

  const handleCheckCategory = (e: React.ChangeEvent<HTMLInputElement>) => {
    props.getDataValue(e.target.value, e.target.name);
  };

  return (
    <div className="radio country">
      {contrys.map((contry) => (
        <>
          <input
            id={`input_country_${contry.id}`}
            type="radio"
            name="categoryId"
            onChange={handleCheckCategory}
            value={contry.id}
          />
          <label htmlFor={`input_country_${contry.id}`}>{contry.name}</label>
        </>
      ))}
    </div>
  );
}

export default HaderCategoryList;
