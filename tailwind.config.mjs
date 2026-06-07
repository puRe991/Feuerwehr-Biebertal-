/** @type {import('tailwindcss').Config} */
export default {
  content: ['./src/**/*.{astro,html,js,jsx,md,mdx,svelte,ts,tsx,vue}'],
  theme: {
    extend: {
      colors: {
        brand: {
          navy: '#071a33',
          blue: '#0d2b52',
          slate: '#172033',
          red: '#d71920',
          gold: '#f7b733',
          mist: '#eef4f8'
        }
      },
      boxShadow: {
        soft: '0 18px 60px rgb(7 26 51 / 0.12)'
      }
    }
  }
};
