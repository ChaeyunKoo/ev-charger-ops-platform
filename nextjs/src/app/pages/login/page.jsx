'use client';

import { useState } from 'react';
import Image from 'next/image';
import styles from './page.module.css';
import logoImage from './logo.png';

export default function Login() {
  const [userId, setUserId] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // 로그인 로직 구현
    console.log('로그인 시도:', { userId, password });
  };

  return (
    <div className={styles.container}>
      <div className={styles.loginWrapper}>
        <div className={styles.header}>
          <div className={styles.logoContainer}>
            <Image
              src={logoImage}
              alt="한국환경공단 로고"
              className={styles.logo}
              priority
            />
          </div>
          <h1 className={styles.title}>한국환경공단</h1>
          <p className={styles.subtitle}>Korea Environment Corporation</p>
        </div>

        <form className={styles.loginForm} onSubmit={handleSubmit}>
          <div className={styles.inputGroup}>
            <input
              type="text"
              id="userId"
              className={styles.input}
              placeholder="사용자ID"
              value={userId}
              onChange={(e) => setUserId(e.target.value)}
            />
          </div>

          <div className={styles.inputGroup}>
            <input
              type="password"
              id="password"
              className={styles.input}
              placeholder="비밀번호"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>

          <button type="submit" className={styles.loginButton}>
            로그인
          </button>

          <div className={styles.signupLink}>
            <a href="#" className={styles.signupText}>회원가입</a>
          </div>
        </form>
      </div>
    </div>
  );
}
