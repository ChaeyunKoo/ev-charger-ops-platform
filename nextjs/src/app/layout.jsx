export const metadata = {
  title: 'EV Charger Ops Platform',
  description: '전기차 충전소 운영 플랫폼',
};

export default function RootLayout({ children }) {
  return (
    <html lang="ko">
      <body>{children}</body>
    </html>
  );
}
