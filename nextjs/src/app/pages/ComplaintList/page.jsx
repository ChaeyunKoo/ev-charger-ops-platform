'use client';

import { useState } from 'react';
import styles from './page.module.css';

export default function ComplaintList() {
  const [filterType, setFilterType] = useState('unprocessed'); // 'unprocessed' or 'processed'
  const [currentPage, setCurrentPage] = useState(1);
  const [itemsPerPage] = useState(10);
  const [selectedItems, setSelectedItems] = useState([]);

  // Sample data - replace with actual data fetching
  const complaints = [
    { id: 1, number: 1, title: '민원 제목 1', status: '미처리', category: '기타', date: '2024-01-01 10:00' },
    { id: 2, number: 2, title: '민원 제목 2', status: '처리완료', category: '시설', date: '2024-01-02 11:00' },
  ];

  const totalCount = 10;
  const totalPages = Math.ceil(totalCount / itemsPerPage);

  const handleFilterChange = (type) => {
    setFilterType(type);
    setCurrentPage(1);
    setSelectedItems([]);
  };

  const handleSearch = () => {
    // 검색 로직 구현
    console.log('검색 실행');
  };

  const handleReset = () => {
    // 초기화 로직 구현
    console.log('초기화 실행');
    setFilterType('unprocessed');
    setCurrentPage(1);
    setSelectedItems([]);
  };

  const handlePageChange = (page) => {
    if (page >= 1 && page <= totalPages) {
      setCurrentPage(page);
    }
  };

  const handleSelectItem = (id) => {
    setSelectedItems(prev =>
      prev.includes(id) ? prev.filter(item => item !== id) : [...prev, id]
    );
  };

  const handleSelectAll = (checked) => {
    if (checked) {
      setSelectedItems(complaints.map(item => item.id));
    } else {
      setSelectedItems([]);
    }
  };

  const handleAgentProcess = () => {
    // Agent 처리 로직 구현
    console.log('선택된 민원 Agent 처리:', selectedItems);
  };

  const renderPagination = () => {
    const pages = [];
    if (totalPages <= 7) {
      for (let i = 1; i <= totalPages; i++) {
        pages.push(i);
      }
    } else {
      if (currentPage <= 3) {
        pages.push(1, 2, 3, '...', totalPages);
      } else if (currentPage >= totalPages - 2) {
        pages.push(1, '...', totalPages - 2, totalPages - 1, totalPages);
      } else {
        pages.push(1, '...', currentPage - 1, currentPage, currentPage + 1, '...', totalPages);
      }
    }

    return (
      <div className={styles.pagination}>
        <button
          className={styles.paginationButton}
          onClick={() => handlePageChange(currentPage - 1)}
          disabled={currentPage === 1}
        >
          &lt;
        </button>
        {pages.map((page, index) => (
          <button
            key={index}
            className={`${styles.paginationButton} ${page === currentPage ? styles.paginationActive : ''}`}
            onClick={() => typeof page === 'number' && handlePageChange(page)}
            disabled={page === '...'}
          >
            {page}
          </button>
        ))}
        <button
          className={styles.paginationButton}
          onClick={() => handlePageChange(currentPage + 1)}
          disabled={currentPage === totalPages}
        >
          &gt;
        </button>
      </div>
    );
  };

  return (
    <div className={styles.container}>
      <div className={styles.wrapper}>
        <h1 className={styles.title}>민원 조회</h1>

        <div className={styles.filters}>
          <button
            className={`${styles.filterButton} ${filterType === 'unprocessed' ? styles.filterActive : ''}`}
            onClick={() => handleFilterChange('unprocessed')}
          >
            미처리 민원
          </button>
          <button
            className={`${styles.filterButton} ${filterType === 'processed' ? styles.filterActive : ''}`}
            onClick={() => handleFilterChange('processed')}
          >
            처리된 민원
          </button>
        </div>

        <div className={styles.actionButtons}>
          <button className={styles.searchButton} onClick={handleSearch}>
            🔍 검색
          </button>
          <button className={styles.resetButton} onClick={handleReset}>
            ↻ 초기화
          </button>
        </div>

        <div className={styles.tableControls}>
          <span className={styles.totalCount}>총 {totalCount}건 등록({currentPage}/{totalPages})</span>
          {selectedItems.length > 0 && (
            <button className={styles.agentProcessButton} onClick={handleAgentProcess}>
              선택 민원 Agent 처리
            </button>
          )}
          <span className={styles.itemsPerPage}>{itemsPerPage}개씩</span>
        </div>

        <div className={styles.tableWrapper}>
          <table className={styles.table}>
            <thead>
              <tr>
                <th className={styles.checkboxColumn}>
                  <input
                    type="checkbox"
                    checked={selectedItems.length === complaints.length && complaints.length > 0}
                    onChange={(e) => handleSelectAll(e.target.checked)}
                  />
                </th>
                <th className={styles.numberColumn}>번호</th>
                <th className={styles.statusColumn}>상태</th>
                <th className={styles.titleColumn}>제목</th>
                <th className={styles.categoryColumn}>분류</th>
                <th className={styles.dateColumn}>등록일시</th>
              </tr>
            </thead>
            <tbody>
              {complaints.map((complaint) => (
                <tr key={complaint.id}>
                  <td className={styles.checkboxColumn}>
                    <input
                      type="checkbox"
                      checked={selectedItems.includes(complaint.id)}
                      onChange={() => handleSelectItem(complaint.id)}
                    />
                  </td>
                  <td className={styles.numberColumn}>{complaint.number}</td>
                  <td className={styles.statusColumn}>
                    <span className={complaint.status === '미처리' ? styles.statusUnprocessed : styles.statusProcessed}>
                      {complaint.status}
                    </span>
                  </td>
                  <td className={styles.titleColumn}>{complaint.title}</td>
                  <td className={styles.categoryColumn}>{complaint.category}</td>
                  <td className={styles.dateColumn}>{complaint.date}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        {renderPagination()}
      </div>
    </div>
  );
}
