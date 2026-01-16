'use client';

import { useState, useEffect } from 'react';
import { useSearchParams, useRouter } from 'next/navigation';
import styles from './page.module.css';

export default function ComplaintDetail() {
  const searchParams = useSearchParams();
  const router = useRouter();
  const complaintId = searchParams.get('id');

  // 샘플 데이터 - 실제로는 API에서 가져와야 함
  const [complaint, setComplaint] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // 실제로는 API 호출로 데이터를 가져와야 함
    // 여기서는 샘플 데이터 사용
    const sampleComplaints = {
      '1': {
        id: 1,
        title: '충전기 고장 민원',
        category: '충전기 고장',
        receivedDate: '2024-01-15 10:00',
        content: '충전소에 설치된 충전기가 작동하지 않습니다. 충전을 시도했지만 전원이 들어오지 않고, 화면도 켜지지 않습니다. 다른 충전기도 모두 사용 중이어서 급하게 충전이 필요한 상황입니다. 빠른 조치 부탁드립니다.',
        hasReply: false, // 답변 여부
        reply: null
      },
      '2': {
        id: 2,
        title: '결제 오류 민원',
        category: '결제 오류',
        receivedDate: '2024-01-14 11:00',
        content: '충전 완료 후 결제가 중복으로 처리되었습니다. 한 번의 충전에 대해 두 번의 결제가 발생했고, 카드사에 문의한 결과 실제로 두 번의 승인이 들어간 것을 확인했습니다. 환불 처리 부탁드립니다.',
        hasReply: true,
        reply: '안녕하세요. 결제 중복 처리 문제로 불편을 드려 죄송합니다. 확인 결과 중복 결제가 확인되어 즉시 환불 처리하겠습니다. 환불은 영업일 기준 3-5일 내에 완료됩니다.'
      },
      '3': {
        id: 3,
        title: 'AS 연결 지연 민원',
        category: 'AS 콜센터 연결 지연',
        receivedDate: '2024-01-13 14:00',
        content: '충전기 고장으로 AS 콜센터에 전화를 걸었는데 연결이 너무 오래 걸립니다. 10분 이상 대기했지만 연결되지 않아서 민원을 접수합니다. 빠른 응대 부탁드립니다.',
        hasReply: false,
        reply: null
      }
    };

    if (complaintId && sampleComplaints[complaintId]) {
      setComplaint(sampleComplaints[complaintId]);
    } else {
      // 기본 샘플 데이터
      setComplaint({
        id: complaintId || 1,
        title: '민원 제목',
        category: '기타',
        receivedDate: '2024-01-15 10:00',
        content: '민원 내용이 여기에 표시됩니다.',
        hasReply: false,
        reply: null
      });
    }
    setLoading(false);
  }, [complaintId]);

  const handleBack = () => {
    router.push('/pages/ComplaintList');
  };

  if (loading) {
    return (
      <div className={styles.container}>
        <div className={styles.wrapper}>
          <div className={styles.loading}>로딩 중...</div>
        </div>
      </div>
    );
  }

  if (!complaint) {
    return (
      <div className={styles.container}>
        <div className={styles.wrapper}>
          <div className={styles.error}>민원을 찾을 수 없습니다.</div>
        </div>
      </div>
    );
  }

  return (
    <div className={styles.container}>
      <div className={styles.wrapper}>
        <div className={styles.header}>
          <button className={styles.backButton} onClick={handleBack}>
            ← 목록으로
          </button>
        </div>

        <div className={styles.content}>
          {/* 상태 배지 */}
          <div className={styles.statusBadge}>
            <span className={complaint.hasReply ? styles.statusCompleted : styles.statusPending}>
              {complaint.hasReply ? '답변 완료' : '미처리'}
            </span>
          </div>

          {/* 민원 제목 */}
          <h1 className={styles.title}>{complaint.title}</h1>

          {/* 민원 유형 및 접수 일시 */}
          <div className={styles.metaInfo}>
            <div className={styles.metaItem}>
              <span className={styles.metaLabel}>민원 유형:</span>
              <span className={styles.metaValue}>{complaint.category}</span>
            </div>
            <div className={styles.metaItem}>
              <span className={styles.metaLabel}>접수 일시:</span>
              <span className={styles.metaValue}>{complaint.receivedDate}</span>
            </div>
          </div>

          {/* 민원 내용 */}
          <div className={styles.contentSection}>
            <h2 className={styles.sectionTitle}>민원 내용</h2>
            <div className={styles.contentText}>
              {complaint.content.split('\n').map((line, index) => (
                <p key={index}>{line}</p>
              ))}
            </div>
          </div>

          {/* 답변 섹션 */}
          {complaint.hasReply && complaint.reply && (
            <div className={styles.replySection}>
              <h2 className={styles.sectionTitle}>답변</h2>
              <div className={styles.replyText}>
                {complaint.reply.split('\n').map((line, index) => (
                  <p key={index}>{line}</p>
                ))}
              </div>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}
