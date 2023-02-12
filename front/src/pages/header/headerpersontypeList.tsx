/* eslint-disable react/destructuring-assignment */
import personTypeData from '../helper/dummy/persontype';

interface PersonType {
  id: number;
  name: string;
}

function HeaderPersontypeList(props: any) {
  const list = personTypeData;

  const personTypes: PersonType[] = list as PersonType[];

  const handleCheckPersonType = (e: React.ChangeEvent<HTMLInputElement>) => {
    props.getDataValue(e.target.value, e.target.name);
  };

  return (
    <div className="radio persontype">
      {personTypes.map((personType) => (
        <>
          <input
            id={`input_persontype_${personType.id}`}
            type="radio"
            name="persontype"
            onChange={handleCheckPersonType}
            value={personType.id}
          />
          <label htmlFor={`input_persontype_${personType.id}`}>
            {personType.name}
          </label>
        </>
      ))}
    </div>
  );
}

export default HeaderPersontypeList;
