import { COACH_COLORS } from '@constants/index';
import type { Coach as CoachType } from '@typings/domain';
import { CardContainer } from './styles';

interface CoachProps {
  coach: CoachType;
}

const Card = ({ coach }: CoachProps) => {
  return (
    <CardContainer color={COACH_COLORS[coach.id]}>
      <div>
        <img src={coach.image} alt="코치 프로필 이미지" />
        <span>{coach.name}</span>
        <p>{coach.description}</p>
        <button>예약하기</button>
      </div>
    </CardContainer>
  );
};

export default Card;
