
<script>
import Locations from './Locations.vue';
  export default {
    name: 'Modal',
    components: {
        Locations,
    },
    methods: {
      close() {
        this.$emit('close');
      },

    },
  };
</script>

<template>
  <div class="modal-backdrop">
    <div class="modal">
          <Locations></Locations>

      <footer class="modal-footer">
        <button
          type="button"
          class="btn-theme"
          @click="close"
        >
          Exit Walk Route
        </button>
      </footer>
    </div>
  </div>
</template>
<style>
  .modal-backdrop {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.6);
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .modal {
    background: #FFFFFF;
    box-shadow: 2px 2px 40px 1px black;
    display: flex;
    flex-direction: column;
  }

  .modal-footer {
    padding: 15px;
    display: flex;
  }

  .modal-footer {
    border-top: 1px solid #eeeeee;
    flex-direction: column;
    justify-content: flex-end;
  }

  .modal-body {
    position: relative;
    padding: 20px 10px;
  }


  .btn-theme {
    color: #0870a3;
    font-weight: bold;
    background: #ED815A;
    border: 1px solid #ED815A;
    width: 200px;
    border-radius: 8px;
  }
  .btn-theme:hover {
      cursor: pointer;
          background: #f5b59e;
    border: 1px solid #f5b59e;
  }
</style>